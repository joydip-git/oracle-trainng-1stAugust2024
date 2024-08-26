import { useCountState } from "./state";

const First = () => {
    const [countState, countDispatch] = useCountState()

    return (
        <div>
            First Count: &nbsp;{countState.count}
            <br />
            <button type="button" onClick={
                () => countDispatch({ type: 'INCREASE' })
            }>Increase</button>
        </div>
    );
}

export default First