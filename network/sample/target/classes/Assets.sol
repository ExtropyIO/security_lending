// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.7.0;

contract Assets {
    enum AssetType {Equity, Digital}

    struct Asset {
        string ID;
        AssetType assetType;
        uint256 lastPrice;
    }

    mapping(string => Asset) assetByID;

    function addAsset(
        string memory _ID,
        AssetType _assetType,
        uint256 _value
    ) external {
        assetByID[_ID] = Asset({
            ID: _ID,
            assetType: _assetType,
            lastPrice: _value
        });
    }

    function markAsset(string memory _ID, uint256 _price) external {
        assetByID[_ID].lastPrice = _price;
    }

    function getAssetPrice(string memory _ID) external view returns (uint256) {
        return assetByID[_ID].lastPrice;
    }
}
