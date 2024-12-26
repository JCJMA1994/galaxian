document.addEventListener('DOMContentLoaded', () => {
    const player1 = document.getElementById('player1');
    const player2 = document.getElementById('player2');

    // Player 1 Controls
    document.addEventListener('keydown', (event) => {
        switch (event.key) {
            case 'ArrowLeft':
                movePlayer(player1, -10);
                break;
            case 'ArrowRight':
                movePlayer(player1, 10);
                break;
            case ' ':
                shootBullet(player1);
                break;
        }
    });

    // Player 2 Controls
    document.addEventListener('keydown', (event) => {
        switch (event.key) {
            case 'a':
                movePlayer(player2, -10);
                break;
            case 'd':
                movePlayer(player2, 10);
                break;
            case 'w':
                shootBullet(player2);
                break;
        }
    });

    function movePlayer(player, deltaX) {
        const currentLeft = parseInt(player.style.left || '0');
        player.style.left = `${currentLeft + deltaX}px`;
    }
    function startGame() {
        setInterval(function() {
            document.querySelector('[value="Move Enemies"]').click();
        }, 1000); // Move enemies every second
    }

// Call startGame when the page loads
    window.onload = startGame;

    function shootBullet(player) {
        const bullet = document.createElement('div');
        bullet.className = 'bullet';
        bullet.style.left = `${player.offsetLeft + 20}px`;
        bullet.style.bottom = '50px';
        document.getElementById('game-board').appendChild(bullet);

        const bulletInterval = setInterval(() => {
            const currentBottom = parseInt(bullet.style.bottom || '0');
            if (currentBottom > 600) {
                clearInterval(bulletInterval);
                bullet.remove();
            } else {
                bullet.style.bottom = `${currentBottom + 5}px`;
            }
        }, 50);
    }
});
