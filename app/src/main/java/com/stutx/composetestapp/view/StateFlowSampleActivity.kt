/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composetestapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.stutx.composetestapp.view.ui.theme.ComposeTestAppTheme
import com.stutx.composetestapp.viewmodel.SampleActionsViewModel
import com.stutx.composetestapp.viewmodel.SampleGuidanceViewModel
import com.stutx.composeuilib.v3.view.TwoColumnWizard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class StateFlowSampleActivity : ComponentActivity() {

    private val guidanceViewModel: SampleGuidanceViewModel by viewModels()
    private val actionsViewModel: SampleActionsViewModel by viewModels()

    @OptIn(ExperimentalCoroutinesApi::class)
    private val workerScope = CoroutineScope(
        Dispatchers.Default.limitedParallelism(1) +
        SupervisorJob()
    )

    private var clickMonitorJob: Job? = null
    private var focusMonitorJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestAppTheme {
                StateFlowSampleScreen(Modifier)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        clickMonitorJob = workerScope.launch {
            actionsViewModel.clickedAction.collect { value ->
                guidanceViewModel.update(
                    "Focused-Action: id=${value.id}\n" +
                    "Clicked-Action: id=${value.id}\n"
                )
            }
        }
        focusMonitorJob = workerScope.launch {
            actionsViewModel.focusedAction.collect { value ->
                guidanceViewModel.update(
                    "Focused-Action: id=${value.id}\n" +
                            "Clicked-Action: id=${actionsViewModel.clickedAction.value.id}\n"
                )
            }
        }
    }

    override fun onStop() {
        clickMonitorJob?.cancel()
        focusMonitorJob?.cancel()
        super.onStop()
    }
}

@Composable
fun StateFlowSampleScreen(
    modifier: Modifier,
    guidanceViewModel: SampleGuidanceViewModel = viewModel(),
    actionsViewModel: SampleActionsViewModel = viewModel(),
) {
    TwoColumnWizard(modifier, guidanceViewModel, actionsViewModel)
}