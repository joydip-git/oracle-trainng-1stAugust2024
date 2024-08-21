import React from 'react'

type FooterProps = {
    footerMessageValue: string
}
const Footer = (props: Readonly<FooterProps>) => {
    console.log('footer loaded');
    return (
        <div>&nbsp;&copy;{props.footerMessageValue}</div>
    )
}

export default Footer