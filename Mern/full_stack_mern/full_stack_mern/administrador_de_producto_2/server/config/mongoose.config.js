let mongoose = require("mongoose")

mongoose.connect("mongodb://localhost:27017/administrador_de_productos", {
    useNewUrlParser: true,
    UseUnifiedTopology: true
})
.then(()=>console.log("Database connection stablished"))
.catch(err=>console.log("There Was an error with the database connection", err))