/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $.get("/Lab3/CoffeeMachineController", function (data) {
        console.log(data);
        $("#message").html(data.message);
        $("#power").html("" + data.poweredOn);
        $("#waterLevel").html(data.waterLevel + '/' + data.MAX_WATER);
        $("#coffeeBeans").html(data.beansLevel + '/' + data.MAX_BEANS);
    });
    $('#turnOnBtn').click(function () {
        $.get("/Lab3/CoffeeMachineController?func=turnOnOff");
    });
    $('#getCoffeeBtn').click(function () {
        $.get("/Lab3/CoffeeMachineController?func=getRegularCoffee");
    });
    $('#getEspressoBtn').click(function () {
        $.get("/Lab3/CoffeeMachineController?func=getEspressoCoffee");
    });
});

function addWater() {
    var amount = $('#waterAmount').val();
    $.post("/Lab3/CoffeeMachineController", {func: "addWater", amount: amount}, function () {
    });
}

function addCoffeeBeans() {
    var amount = $('#coffeeBeansAmount').val();
    $.post("/Lab3/CoffeeMachineController", {func: "addCoffeeBeans", amount: amount}, function () {
    });
}
