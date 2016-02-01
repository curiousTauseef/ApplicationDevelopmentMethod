/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $.get("/lab4AdvancedCoffeeMachine/AdvancedCoffeeMachineController", function (data) {
        console.log(JSON.stringify(data));
        $("#message").html(data.message);
        $("#power").html("" + data.poweredOn);
        $("#waterLevel").html(data.waterLevel + '/' + data.MAX_WATER);
        $("#coffeeBeans").html(data.beansLevel + '/' + data.MAX_BEANS);
        $("#milkLevel").html(data.milkLevel + '/' + data.MAX_MILK);
    });
    $('#turnOnBtn').click(function () {
        $.get("/lab4AdvancedCoffeeMachine/AdvancedCoffeeMachineController?func=turnOnOff");
    });
    $('#getCoffeeBtn').click(function () {
        $.get("/lab4AdvancedCoffeeMachine/AdvancedCoffeeMachineController?func=getRegularCoffee");
    });
    $('#getEspressoBtn').click(function () {
        $.get("/lab4AdvancedCoffeeMachine/AdvancedCoffeeMachineController?func=getEspressoCoffee");
    });
    $('#getCappuccinoBtn').click(function () {
        $.get("/lab4AdvancedCoffeeMachine/AdvancedCoffeeMachineController?func=getCappuccino");
    });
});

function addWater() {
    var amount = $('#waterAmount').val();
    $.post("/lab4AdvancedCoffeeMachine/AdvancedCoffeeMachineController", {func: "addWater", amount: amount}, function () {
    });
}

function addCoffeeBeans() {
    var amount = $('#coffeeBeansAmount').val();
    $.post("/lab4AdvancedCoffeeMachine/AdvancedCoffeeMachineController", {func: "addCoffeeBeans", amount: amount}, function () {
    });
}

function addMilk() {
    var amount = $('#milkAmount').val();
    $.post("/lab4AdvancedCoffeeMachine/AdvancedCoffeeMachineController", {func: "addMilk", amount: amount}, function () {
    });
}
