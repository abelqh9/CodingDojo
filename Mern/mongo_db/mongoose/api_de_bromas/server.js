let express = require("express");
let app = express();

// This will fire our mongoose.connect statement to initialize our database connection
require("./server/config/mongoose.config");

app.use(express.json(), express.urlencoded({ extended: true}));

// This is where we import the joke routes function from our joke.routes.js file
const AllMyJokerRoutes = require("./server/routes/joker.routes");
AllMyJokerRoutes(app);

app.listen(8000, () => console.log("The server is all fired up on port 8000"))