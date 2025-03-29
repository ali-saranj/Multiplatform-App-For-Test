package org.company.test.core.baseclass

interface Reducer<State : Reducer.ViewState, Event : Reducer.ViewEvent, Effect : Reducer.ViewEffect> {
    interface ViewState

    interface ViewEvent

    interface ViewEffect

}