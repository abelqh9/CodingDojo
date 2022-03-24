let mongoose = require("mongoose")

let PlayerSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [true, "The name is required"],
        minLength: [2, "The name must have at least 3 characters"],
        trim: true
    },
    position: {
        type: String,
        trim: true
    },
    games_status:{
        1: 0,
        2: 0,
        3: 0
    }
})

module.exports = mongoose.model("Player", PlayerSchema);