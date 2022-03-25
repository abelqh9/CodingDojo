let express = require("express");
let app = express();

let server = app.listen(8000, ()=>console.log("The server is all fired up on port 8000"))

let io = require("socket.io")(server, {
    cors: {
        origin: "http://localhost:3000"
    }
});

io.on("connection", socket =>{
    console.log("Nueva conexion: ", socket.id);

    socket.emit("serverSaysHello", "Hola,  soy el servidor :)")
})