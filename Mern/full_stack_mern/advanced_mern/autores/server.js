let express = require("express");
let cors = require("cors");

let app = express()
app.use(express.json(), express.urlencoded({ extended: true }), cors())

require("./server/config/mongoose.config")

require("./server/routes/Author.routes")(app)

app.listen(8000, ()=> console.log("Listening at Port 8000"))