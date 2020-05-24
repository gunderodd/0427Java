let submit3 = document.getElementById("submit3")
let rtfeed = document.getElementById("repeatFeedback")

submit3.addEventListener("click", test)
submit3.addEventListener("keyup", test)


function test() {
    let feedback = document.getElementById("feedbackValue").value
    console.log(feedback)
    fetch('https://jsonplaceholder.typicode.com/posts', {
        method: 'POST',
        body: JSON.stringify({
            title: "Feedback",
            body: feedback,
            userId: 1
        }),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
        })
        .then(response => response.json())
        // .then(json => console.log(json))
        .then(json => repeatFeedback(json))

        function repeatFeedback(json) {
            console.log(json.body)
            rtfeed.innerHTML = json.body
        }
}


// Output
// {
//     id: 1,
//     title: 'foo',
//     body: 'bar',
//     userId: 1
// }