type ContentProps = {
    contentValue: string,
    contentHandler: () => void
}

const Content = (props: Readonly<ContentProps>) => {
    console.log('content loaded');
    const { contentValue, contentHandler } = props
    return (
        <div>
            {contentValue}
            <br />
            <button type="button" onClick={contentHandler}>Change Content</button>
        </div>
    )
}

export default Content