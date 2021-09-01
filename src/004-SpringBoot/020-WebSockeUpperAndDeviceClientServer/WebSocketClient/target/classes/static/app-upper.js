var ws = null

var url = "ws://localhost:8082/upper"

function setConnected(connected)
{
    document.getElementById('connect').disabled = connected
    document.getElementById('disconnect').disabled = !connected
    document.getElementById('echo').disabled = !connected
}

function connect()
{
    ws = new WebSocket(url)
    ws.onopen = function () {
        setConnected(true)
    }
    ws.onmessage = function (event) {
        log(event.data.toString())
    }

    ws.onclose = function () {
        setConnected(false)
        log("Connection closed")
    }
}

function disconnect()
{
    if (ws != null) {
        ws.close()
        ws = null
    }

    setConnected(false)
}

function echo() {
    if (ws != null) {
        var msg = document.getElementById("message").value
        ws.binaryType = 'arraybuffer'
        ws.send(msg)
    }
    else
        alert("Connection not established")
}

function log(message)
{
    var console = document.getElementById('logging')
    var p = document.createElement('p')

    p.appendChild(document.createTextNode(message))
    console.appendChild(p)

    while (console.childNodes.length > 12)
        console.removeChild(console.firstChild)

    console.scrollTop = console.scrollHeight
}
