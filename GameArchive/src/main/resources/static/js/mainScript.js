function openModal(modalId) {
    var modal = document.getElementById(modalId);
    modal.style.display = "block";
}

window.addEventListener('DOMContentLoaded', function () {
    var userImgs = document.querySelectorAll('[data-role="userImg"]');
    userImgs.forEach(function (userImg) {
        userImg.addEventListener('click', function () {
            openModal('userInfoModal');
        });
    });

    var dms = document.querySelectorAll('[data-role="dm"]');
    dms.forEach(function (dm) {
        dm.addEventListener('click', function () {
            openModal('chatModal'); // dmModal은 dm 요소를 클릭했을 때 열리는 모달의 id를 가정한 것입니다.
        });
    });

    var dms = document.querySelectorAll('[data-role="sponeButton"]');
    dms.forEach(function (dm) {
        dm.addEventListener('click', function () {
            openModal('sponeModal'); // dmModal은 dm 요소를 클릭했을 때 열리는 모달의 id를 가정한 것입니다.
        });
    });
});
// 모달 열기 함수
function openModal(modalId, userInfo) {
    document.getElementById(modalId).classList.add('open');
    // 모달 내용 설정
    document.getElementById('userProfile').src = userInfo.profileImage;
    document.getElementById('userName').textContent = userInfo.name;
    document.getElementById('userTitle').textContent = userInfo.title;
    document.getElementById('userLevel').textContent = userInfo.level;
    document.getElementById('userSponsorCount').textContent = "스폰서 수: " + userInfo.sponsorCount;
}

document.getElementById('addBoard').addEventListener('click', function () {
    openModal('addBoardModal');
});
// 게임 버튼 클릭 이벤트 누면 gemeList 의 너비를 1/3 으로 늘리기. 늘리는 속도랑 줄어드는 속도를 transition 으로 조절하기.
document.getElementById('gameBt').addEventListener('click', function () {
    var gameList = document.getElementById('gameList');
    if (gameList.style.width == '0px') {
        gameList.style.width = '22%';
        if (document.getElementById('userUtil').style.width != '0px') {
            document.getElementById('userUtil').style.width = '0px';
        }
    } else {
        gameList.style.width = '0px';
    }
    blur();
});
// 유저 버튼 클릭 이벤트 누면 userUtil 의 너비를 1/3 으로 늘리기. 늘리는 속도랑 줄어드는 속도를 transition 으로 조절하기.
document.getElementById('userBtn').addEventListener('click', function () {
    var userUtil = document.getElementById('userUtil');
    if (userUtil.style.width == '0px') {
        userUtil.style.width = '22%';
        if (document.getElementById('gameList').style.width != '0px') {
            document.getElementById('gameList').style.width = '0px';
        }
    } else {
        userUtil.style.width = '0px';
    }
    blur();
});

function openModal(modalId) {
    var modal = document.getElementById(modalId);
    modal.style.display = "block"; // 모달을 열 때 display 속성을 block으로 설정
    setTimeout(function () {
        modal.style.opacity = "1"; // 모달 창의 opacity를 1로 설정
    }, 50); // display 속성이 변경된 후에 opacity를 변경하도록 setTimeout 사용
    if (modalId === 'chatModal') {
        document.getElementById('message').focus(); // 채팅 모달이 열리면 메시지 입력창에 포커스
        document.getElementById('chatList').scrollTop = document.getElementById('chatList').scrollHeight; // 채팅 모달이 열리면 스크롤을 맨 아래로 이동
    }
}

function closeModal(modalId) {
    var modal = document.getElementById(modalId);
    modal.style.opacity = "0"; // 모달 창의 opacity를 0으로 설정
    setTimeout(function () {
        modal.style.display = "none"; // 모달 창의 display를 none으로 변경
    }, 1000);
}

function blur() {
    if (document.getElementById('gameList').style.width != '0px' || document.getElementById('userUtil').style.width != '0px') {
        document.getElementById('board').style.filter = 'blur(5px)';
    } else {
        document.getElementById('board').style.filter = 'none';
    }
}