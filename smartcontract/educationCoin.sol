// SPDX-License-Identifier: MIT
pragma solidity ^0.7.6; // Für bessere Kompatibilität mit älteren EVM-Versionen

import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/v3.4.0/contracts/token/ERC20/ERC20.sol";
import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/v3.4.0/contracts/access/Ownable.sol";

contract EduCoin is ERC20, Ownable {
    address public schoolWallet;

    event TokensDistributed(address indexed student, uint256 amount, string testName, string grade);
    event RewardRedeemed(address indexed student, uint256 amount);
    event TokensMinted(address indexed to, uint256 amount);
    event SchoolWalletUpdated(address indexed newSchoolWallet);

    constructor(address _schoolWallet, address initialOwner) ERC20("EduCoin", "EDU") {
        require(_schoolWallet != address(0), "Invalid school wallet address");
        require(initialOwner != address(0), "Invalid owner address");

        schoolWallet = _schoolWallet;

        // Initial supply minted to the school wallet
        _mint(schoolWallet, 1000000 * 10 ** decimals()); // 1,000,000 tokens
        transferOwnership(initialOwner); // Ensure initialOwner is set as the owner of the contract
    }

    /**
     * @dev Distribute tokens to a student from the school wallet.
     * @param student The address of the student.
     * @param wholeTokens The amount of tokens to distribute (in whole units).
     * @param testName The name of the test.
     * @param grade The grade obtained in the test.
     */
    function distributeTokens(
        address student,
        uint256 wholeTokens,
        string calldata testName,
        string calldata grade
    ) external onlyOwner {
        require(student != address(0), "Invalid student address");
        require(wholeTokens > 0, "Amount must be greater than zero");

        uint256 amount = wholeTokens * 10 ** decimals();
        require(balanceOf(schoolWallet) >= amount, "Not enough tokens in school wallet");

        _transfer(schoolWallet, student, amount);
        emit TokensDistributed(student, wholeTokens, testName, grade);
    }

    /**
     * @dev Redeem tokens by transferring them back to the school wallet.
     * @param wholeTokens The amount of tokens to redeem (in whole units).
     */
    function redeemTokens(address studentWallet, uint256 wholeTokens) external {
    require(wholeTokens > 0, "Amount must be greater than zero");
    require(studentWallet != address(0), "Invalid student wallet");

    uint256 amount = wholeTokens * 10 ** decimals();
    require(balanceOf(studentWallet) >= amount, "Not enough tokens to redeem");

    _transfer(studentWallet, schoolWallet, amount);
    emit RewardRedeemed(studentWallet, wholeTokens);
}


    /**
     * @dev Change the school wallet address (only callable by the owner).
     * @param newSchoolWallet The new school wallet address.
     */
    function setSchoolWallet(address newSchoolWallet) external onlyOwner {
        require(newSchoolWallet != address(0), "Invalid address");
        schoolWallet = newSchoolWallet;
        emit SchoolWalletUpdated(newSchoolWallet);
    }

    /**
     * @dev Mint new tokens and increase the total supply (only callable by the owner).
     * @param wholeTokens The amount of tokens to mint (in whole units).
     */
    function mint(uint256 wholeTokens) external onlyOwner {
        require(wholeTokens > 0, "Amount must be greater than zero");

        uint256 amount = wholeTokens * 10 ** decimals();
        _mint(schoolWallet, amount);
        emit TokensMinted(schoolWallet, wholeTokens);
    }
}
