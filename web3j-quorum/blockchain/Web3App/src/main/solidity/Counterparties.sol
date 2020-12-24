// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.7.0;

contract Counterparties {
    enum CreditRating {AAA, AA, A, BBB, BB, B, CCC, CC, C, D}

    struct Counterparty {
        CreditRating rating;
    }
    uint256 numberCounterparties;
    mapping(string => Counterparty) counterparties;

    event CounterpartyCreated(string indexed name, CreditRating indexed rating);

    function createCounterparty(string memory _name, CreditRating _rating)
        external
    {
        counterparties[_name] = Counterparty({rating: _rating});
        numberCounterparties++;
        emit CounterpartyCreated(_name, _rating);
    }

    function getNumberOfCounterparties() external view returns (uint256) {
        return numberCounterparties;
    }

    function getCounterpartyRatingByName(string memory _name)
        external
        view
        returns (CreditRating)
    {
        return counterparties[_name].rating;
    }
}
