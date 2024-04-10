// Modal open function
function openModal(modalId, userInfo) {
    const modal = document.getElementById(modalId);
    if (modal) {
        modal.style.display = "block"; // Set modal display to block
        setTimeout(function () {
            modal.style.opacity = "1"; // Set modal opacity to 1
        }, 50); // Change opacity after changing display using setTimeout

        // If the modal is the chatModal, focus on the message input and scroll to the bottom
        if (modalId === 'chatModal') {
            const message = document.getElementById('message');
            const chatList = document.getElementById('chatList');
            if (message && chatList) {
                message.focus();
                chatList.scrollTop = chatList.scrollHeight;
            }
        }

        // If the modal is the userInfoModal, set the user information
        if (modalId === 'userInfoModal' && userInfo) {
            const userProfile = document.getElementById('userProfile');
            const userName = document.getElementById('userName');
            const userTitle = document.getElementById('userTitle');
            const userLevel = document.getElementById('userLevel');
            const userSponsorCount = document.getElementById('userSponsorCount');
            if (userProfile && userName && userTitle && userLevel && userSponsorCount) {
                userProfile.src = userInfo.profileImage;
                userName.textContent = userInfo.name;
                userTitle.textContent = userInfo.title;
                userLevel.textContent = userInfo.level;
                userSponsorCount.textContent = "스폰서 수: " + userInfo.sponsorCount;
            }
        }

        // If the modal is the myInfoModal, open it
        if (modalId === 'myInfoModal') {
            // Add logic to open myInfoModal here
            // For now, let's just console.log to indicate the opening of myInfoModal
            console.log('myInfoModal opened');
        }
    }
}

// Modal close function
function closeModal(modalId) {
    const modal = document.getElementById(modalId);
    if (modal) {
        modal.style.opacity = "0"; // Set modal opacity to 0
        setTimeout(function () {
            modal.style.display = "none"; // Set modal display to none
        }, 1000);
    }
}

// Function to blur the board
function blur() {
    const gameList = document.getElementById('gameList');
    const userUtil = document.getElementById('userUtil');
    const board = document.getElementById('board');
    if (gameList && userUtil && board) {
        if (gameList.style.width !== '0px' || userUtil.style.width !== '0px') {
            board.style.filter = 'blur(5px)';
        } else {
            board.style.filter = 'none';
        }
    }
}

// Event listeners
window.addEventListener('DOMContentLoaded', function () {
    // Add click event listeners to elements with data-role="userImg" to open the userInfoModal
    const userImgs = document.querySelectorAll('[data-role="userImg"]');
    userImgs.forEach(function (userImg) {
        userImg.addEventListener('click', function () {
            openModal('userInfoModal');
        });
    });

    const userImage = document.querySelectorAll('[data-role="userImage"]');
    userImage.forEach(function (userImg) {
        userImg.addEventListener('click', function () {
            openModal('myInfoModal');
        });
    });

    // Add click event listener to userImg to open the myInfo modal
    const userImg = document.getElementById('userImg');
    if (userImg) {
        userImg.addEventListener('click', function () {
            console.log('userImg clicked');
            openModal('myInfo');
        });
    }

    // Add click event listeners to elements with data-role="dm" to open the chatModal
    const dms = document.querySelectorAll('[data-role="dm"]');
    dms.forEach(function (dm) {
        dm.addEventListener('click', function () {
            openModal('chatModal');
        });
    });

    const chargeBtn = document.getElementById('chargeBtn');
    if (chargeBtn) {
        chargeBtn.addEventListener('click', function () {
            openModal('chargeModal');
        });
    }

    const chargeForm = document.getElementById('chargeForm');
    if (chargeForm) {
        chargeForm.addEventListener('submit', function(event) {
            event.preventDefault();
            // Add charge logic here
        });
    }

    // Add click event listeners to elements with data-role="sponeButton" to open the sponeModal
    const spones = document.querySelectorAll('[data-role="sponeButton"]');
    spones.forEach(function (spone) {
        spone.addEventListener('click', function () {
            openModal('sponeModal');
        });
    });

    // Add submit event listener to userInfoForm
    const userInfoForm = document.getElementById('userInfoForm');
    if (userInfoForm) {
        userInfoForm.addEventListener('submit', function(event) {
            event.preventDefault();
            // Add user information update logic here
        });
    }

    // Add click event listener to addBoard to open the addBoardModal
    const addBoard = document.getElementById('addBoard');
    if (addBoard) {
        addBoard.addEventListener('click', function () {
            openModal('addBoardModal');
        });
    }

    // Add click event listener to gameBt to toggle the width of gameList
    const gameBt = document.getElementById('gameBt');
    if (gameBt) {
        gameBt.addEventListener('click', function () {
            const gameList = document.getElementById('gameList');
            const userUtil = document.getElementById('userUtil');
            if (gameList && userUtil) {
                if (gameList.style.width === '0px') {
                    gameList.style.width = '22%';
                    if (userUtil.style.width !== '0px') {
                        userUtil.style.width = '0px';
                    }
                } else {
                    gameList.style.width = '0px';
                }
                blur();
            }
        });
    }

    // Add click event listener to userBtn to toggle the width of userUtil
    const userBtn = document.getElementById('userBtn');
    if (userBtn) {
        userBtn.addEventListener('click', function () {
            const userUtil = document.getElementById('userUtil');
            const gameList = document.getElementById('gameList');
            if (userUtil && gameList) {
                if (userUtil.style.width === '0px') {
                    userUtil.style.width = '22%';
                    if (gameList.style.width !== '0px') {
                        gameList.style.width = '0px';
                    }
                } else {
                    userUtil.style.width = '0px';
                }
                blur();
            }
        });
    }
});