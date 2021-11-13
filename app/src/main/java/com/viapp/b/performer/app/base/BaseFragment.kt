package com.viapp.b.performer.app.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.viapp.b.performer.app.ui.theme.PerformerTheme

abstract class BaseFragment : Fragment() {

    @Composable
    abstract fun ShowContent()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                PerformerTheme {
                    ShowContent()
                }
            }
        }
    }
}