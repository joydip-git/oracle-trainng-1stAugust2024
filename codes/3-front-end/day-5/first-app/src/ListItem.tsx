import { useContext } from "preact/hooks"
import ColorContext from "./color-context"

type ListItemProps = {
    product: any
}

const ListItem = (props: Readonly<ListItemProps>) => {

    //const colorContextData = useContext(ColorContext)
    const { colorName, changeColorHandler } = useContext(ColorContext)

    return (
        // <li style={{ backgroundColor: colorContextData.colorName }}>
        <li style={{ backgroundColor: colorName }}>
            <div>
                {props.product.productName}
                &nbsp;&nbsp;
                {/* <button type="button" style={{ color: 'black' }}
                    onClick={
                        () => colorContextData.changeColorHandler('burlywood')
                    }>
                    Change Color
                </button> */}
                <button type="button" style={{ color: 'black' }}
                    onClick={
                        () => changeColorHandler('burlywood')
                    }>
                    Change Color
                </button>
            </div>
        </li>
    )
}

export default ListItem