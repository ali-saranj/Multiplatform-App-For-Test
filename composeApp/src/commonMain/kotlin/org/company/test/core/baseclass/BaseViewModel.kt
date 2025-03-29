package org.company.test.core.baseclass

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<
        State : Reducer.ViewState,
        Event : Reducer.ViewEvent,
        Effect : Reducer.ViewEffect
        > : ViewModel(), Reducer<State, Event, Effect> {

    // StateFlow for current UI state
    private val _state: MutableStateFlow<State> by lazy { MutableStateFlow(initialState()) }
    val state: StateFlow<State> = _state.asStateFlow()

    // Channel for one-time effects (e.g. toast, nav)
    private val _effect: Channel<Effect> = Channel(Channel.BUFFERED)
    val effect: Flow<Effect> = _effect.receiveAsFlow()

    // Entry point for events
    fun sendEvent(event: Event) {
        viewModelScope.launch {
            handleEvent(event)
        }
    }

    protected abstract fun initialState(): State
    protected abstract suspend fun handleEvent(event: Event)

    // Update UI state
    protected fun setState(reducer: State.() -> State) {
        _state.value = _state.value.reducer()
    }

    // Send one-time UI effect
    protected fun sendEffect(builder: () -> Effect) {
        viewModelScope.launch {
            _effect.send(builder())
        }
    }
}
