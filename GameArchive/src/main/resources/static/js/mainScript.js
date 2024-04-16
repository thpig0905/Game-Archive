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
            const boardIdInput = modal.querySelector('input[name="boardId"]');
            if (message && chatList && boardIdInput) {
                message.focus();
                chatList.scrollTop = chatList.scrollHeight;
                boardIdInput.value = boardId; // Set the boardId
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
        }, 1000); // Change display after changing opacity using setTimeout
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

    // Add click event listeners to elements with data-role="dm" to open the chatModal with the correct boardId
    document.querySelectorAll('[data-role="dm"]').forEach(function(dmButton) {
        dmButton.addEventListener('click', function() {
            var boardId = this.getAttribute('data-boardId');
            fetch('/board/' + boardId + '/dms')
                .then(response => response.json())
                .then(dms => {
                    var chatList = document.getElementById('chatList');
                    chatList.innerHTML = ''; // Clear the chat list
                    dms.forEach(function(dm) {
                        var chatItem = document.createElement('div');
                        chatItem.className = 'chatItem p-2 rounded-lg bg-white mb-2';

                        var userName = document.createElement('h3');
                        userName.className = 'font-bold text-gray-700';
                        userName.textContent = dm.userName;
                        chatItem.appendChild(userName);

                        var message = document.createElement('p');
                        message.className = 'text-gray-600';
                        message.textContent = dm.message;
                        chatItem.appendChild(message);

                        chatList.appendChild(chatItem);
                    });

                    // Open the chatModal after fetching the DMs
                    openModal('chatModal');

                    // Set the boardId
                    var boardIdInput = document.getElementById('boardId');
                    if (boardIdInput) {
                        boardIdInput.value = boardId;
                    }
                });
        });
    });

    document.querySelectorAll('[data-role="sponeButton"]').forEach(function (sponeButton) {
        sponeButton.addEventListener('click', function () {
            // 데이터 속성에서 게시자의 이름과 ID를 가져옵니다.
            var name = this.getAttribute('data-name');
            var userId = this.getAttribute('data-userId');

            // 모달의 내용을 업데이트합니다.
            var recipientInput = document.getElementById('recipient');
            recipientInput.value = name;
            recipientInput.readOnly = true;

            // receiver 필드에 userId 값을 설정합니다.
            var receiverInput = document.querySelector('input[name="receiver"]');
            receiverInput.value = userId;

            // 모달을 표시합니다.
            document.getElementById('sponeModal').style.display = 'block';
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

    const chargeBtn = document.getElementById('chargeBtn');
    if (chargeBtn) {
        chargeBtn.addEventListener('click', function () {
            openModal('chargeModal');
        });
    }

    const chargeForm = document.getElementById('chargeForm');
    if (chargeForm) {
        chargeForm.addEventListener('submit', function (event) {
        })
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
        userInfoForm.addEventListener('submit', function (event) {
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

// 모달 외부를 클릭하면 모달을 닫습니다.
window.addEventListener('click', function (event) {
    ['userInfoModal', 'myInfoModal', 'chatModal', 'sponeModal', 'chargeModal', 'addBoardModal'].forEach(function(modalId) {
        if (event.target == document.getElementById(modalId)) {
            closeModal(modalId);
        }
    });
});