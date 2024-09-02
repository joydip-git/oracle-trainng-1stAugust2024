/*
const http = require('http')
const fs = require('fs')

const server = http.createServer(
    (req, res) => {
        const data = fs.readFileSync("./src/data.json", { encoding: 'utf-8' })
        return res.end(data.toString())
    }
)

server.listen(3000, () => console.log("server is running..."))
*/

const express = require('express')
const fs = require('fs')

const app = express()

const router = express.Router()
router.get('/people',
    (req, res) => {
        const data = fs.readFileSync("./src/data.json", { encoding: 'utf-8' })
        return res.status(200).send(data.toString())

    })
app.use(express.json())
app.use(router)
app.listen(3000, () => console.log("server is running..."))