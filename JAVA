function encurtarUrl() {
    let url = document.getElementById("input-url").value;
    if (!url) {
        alert("É preciso inserir uma URL para encurtar");
        return;
    }


    let headers = {
        "Content-Type": "application/json",
        "apikey": "95e30454debd4feea3b3a25946c3625c" 
    }

    let linkRequest = {
        destination: url,
        domain: { fullname: "rebrand.ly" }
    }

    fetch("https://api.rebrandly.com/v1/links", {
        method: "POST",
        headers: headers,
        body: JSON.stringify(linkRequest)
    })
    
        .then(response=> response.json())
        .then(json => {
            console.log(json);
            let inputUrl = document.getElementById("input-url");
            inputUrl.value = json.shortUrl;
        });


}
