import { useReducer } from "preact/hooks"

type CountStateType = {
    count: number
}
export type CountActionType = {
    type: string,
    payload?: number
}

const initialCountState: CountStateType = {
    count: 0
}

const countStateReducer = (state: CountStateType, action: CountActionType): CountStateType => {
    switch (action.type) {
        case 'INCREASE':
            return {
                ...state,
                count: state.count + (action.payload ? action.payload : 1)
            }
        case 'DECREASE':
            return {
                ...state,
                count: state.count - (action.payload ? action.payload : 1)
            }

        default:
            return {
                ...state
            }
    }
}


export function useCountState(initialState: number) {
    let state: CountStateType = {
        count: initialState
    }
    const [stateData, dispatch] = useReducer(
        countStateReducer,
        state
    )
    const dispatchRequest = (newData: number) => {
        //dispatch({ type: '' })
    }

}


