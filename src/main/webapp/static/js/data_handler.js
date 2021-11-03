
export let dataHandler = {
    _api_get: function (url, callback) {
        fetch(url, {
            method: "GET",
            credentials: "same-origin",
            headers: {"Content-Type": "application/json"},
        })
            .then((response) => response.json()) // parse the response as JSON
            .then((json_response) => callback(json_response)); // Call the `callback` with the returned object
    },

    getApiData: function (url, callback) {
        console.log("here");
        dataHandler._api_get(url, (response) => {console.log(response);callback(response);})
    }
}