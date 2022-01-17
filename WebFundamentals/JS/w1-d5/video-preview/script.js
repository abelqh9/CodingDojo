let principalVideo = document.querySelector(".principal-video")

principalVideo.addEventListener("mouseover", e=>{
    e.target.play()
})

principalVideo.addEventListener("mouseout", e=>{
    e.target.pause()
})