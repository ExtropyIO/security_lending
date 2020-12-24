const Assets = artifacts.require("Assets");
const Loans = artifacts.require("Loans");
const Counterparties = artifacts.require("Counterparties");


module.exports = function(deployer) {
    deployer.deploy(Assets, 42, { privateFor: ["BULeR8JyUWhiuuCMU/HLA0Q5pzkYT+cHII3ZKBey3Bo="] });
    deployer.deploy(Loans, 42, { privateFor: ["BULeR8JyUWhiuuCMU/HLA0Q5pzkYT+cHII3ZKBey3Bo="] });
    deployer.deploy(Counterparties, 42, { privateFor: ["BULeR8JyUWhiuuCMU/HLA0Q5pzkYT+cHII3ZKBey3Bo="] });
};