import { useCountState } from './state';

const Second = () => {
    const [countState, countDispatch] = useCountState()

    return (
        <div>
            Second Count: &nbsp;{countState.count}
            <br />
            <button type="button" onClick={
                () => countDispatch({ type: 'DECREASE', payload: 5 })
            }>Increase</button>
        </div>
    );
}

export default Second