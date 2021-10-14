
let urlCurrencies = "https://api.coinbase.com/v2/exchange-rates"

let currenciesMap = new Map();



fetch(urlCurrencies, { method: "GET" })

    .then(response => response.json())
    .then(function (result) {


        let obj = result.data.rates;
        let keys = Object.keys(obj);

        for (let val in keys) {
            currenciesMap.set(keys[val], obj[keys[val]]);
        }
        console.log(currenciesMap)
    });




async function grabBaseCurrencies() {

    const result = await updateCurrencies()
   
    postTargetsInMap(grabTargetCurrencies(), result)
    makeTargetMap(grabTargetCurrencies(), result)

    var targetMap  =  makeTargetMap(grabTargetCurrencies(), result)
    mapToJSON(targetMap)

    
};


async function updateCurrencies() {
    var baseCurrencySelection = document.getElementById("userBaseInput").value;
    var urlCurrenciesBase = 'https://api.coinbase.com/v2/exchange-rates?currency=' + baseCurrencySelection;

    var baseCurrenciesMap = new Map();

    return fetch(urlCurrenciesBase, { method: "GET" })

        .then(response => response.json())
        .then(function (result) {


            var obj = result.data.rates;
            var keys = Object.keys(obj);

            for (var val in keys) {
                baseCurrenciesMap.set(keys[val], obj[keys[val]]);
            }
            return baseCurrenciesMap;
        });
};


function grabTargetCurrencies() {
    const targetArray = [];
    for (let i = 1; i <= 10; i++) {
        let targetNumber = "";
        targetNumber = "target" + i;
        if (document.getElementById(targetNumber).value != "") {
            targetArray.push(document.getElementById(targetNumber).value)
        } else { }
    }
    return targetArray;
};


function postTargetsInMap(targetArray, baseCurrenciesMap) {
    let htmlTargets = "";

    
    targetArray.forEach(element => {
        htmlTargets += "<li>" + element + "    :    " + baseCurrenciesMap.get(element) + "</li>";
        document.getElementById("currencies").innerHTML = htmlTargets;
    });
};


function makeTargetMap (targetArray, baseCurrenciesMap){
    const targetMap = new Map();

    targetArray.forEach(element => {
        targetMap.set(element, baseCurrenciesMap.get(element))
    })

    return targetMap;
};


function mapToJSON(targetMap) {

    let jsonObject = {};
    targetMap.forEach((value, key) => {
       jsonObject[key] = value });      

    let JSONtargets = "[" + JSON.stringify(jsonObject) + "]";  
    

    //let JSONtohtmlTargets ="";
    //JSONtohtmlTargets += "<p>" + JSONtargets + "</p>";
    //document.getElementById("HtmlJSONtargets").innerHTML = JSONtohtmlTargets

    console.log(JSONtargets)

    return JSONtargets;  
}

function sendTargetsToBackend () {
 

} 
