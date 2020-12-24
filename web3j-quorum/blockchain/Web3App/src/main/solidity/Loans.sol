// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.7.0;

import "./Assets.sol";

contract Loans {
    struct Loan {
        uint256 loanID;
        uint256 fee;
        string loanedAsset;
        uint256 amount;
        string collateralItems;
        string counterpartyA; // lender
        string counterpartyB;
        uint256 start;
        uint256 end;
        string termsURL;
    }
    mapping(uint256 => Loan) loansByID;
    mapping(string => Loan[]) loansByLender;
    uint256 latestLoanNumber;

    function createLoan(
        string memory _cptyA,
        string memory _cptyB,
        string memory _asset,
        string memory collateral,
        uint256 _amount,
        uint256 _fee,
        uint256 _start,
        uint256 _end,
        string memory _URL
    ) external {
        latestLoanNumber++;
        loansByLender[_cptyA].push(
            Loan({
                loanID: latestLoanNumber,
                fee: _fee,
                loanedAsset: _asset,
                counterpartyA: _cptyA,
                counterpartyB: _cptyB,
                collateralItems: collateral,
                amount: _amount,
                start: _start,
                end: _end,
                termsURL: _URL
            })
        );
    }

    function getLoanCounterparties(uint256 _ID)
        external
        view
        returns (string memory, string memory)
    {
        return (loansByID[_ID].counterpartyA, loansByID[_ID].counterpartyB);
    }

    function getLoanAssetDetails(uint256 _ID)
        external
        view
        returns (string memory, uint256)
    {
        return (loansByID[_ID].loanedAsset, loansByID[_ID].amount);
    }

    function getLoanFee(uint256 _ID) external view returns (uint256) {
        return loansByID[_ID].fee;
    }

    function getLoanTimes(uint256 _ID)
        external
        view
        returns (uint256, uint256)
    {
        return (loansByID[_ID].start, loansByID[_ID].end);
    }

    function getLoanTermsURL(uint256 _ID)
        external
        view
        returns (string memory)
    {
        return loansByID[_ID].termsURL;
    }
}
