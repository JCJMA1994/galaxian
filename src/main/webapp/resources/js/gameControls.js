document.addEventListener('DOMContentLoaded', () => {
    const player1 = document.getElementById('player1');
    const player2 = document.getElementById('player2');
    const enemies = document.querySelectorAll('.enemy');
    const gameBoard = document.getElementById('game-board');
    const gameForm = document.getElementById('gameForm');

    // Game state
    let gameState = {
        player1: {
            score:100,
            lives: 3,
            position: 200,
            active: true
        },
        player2: {
            score:100,
            lives: 3,
            position: 400,
            active: true
        },
        pendingUpdates: {
            player1Lives: 0,
            player2Lives: 0,
            player1Score: 0,
            player2Score: 0,
            needsUpdate: false
        },
        gameOver: false
    };

    let enemyDirection = 1;
    let enemySpeed = 2;

    // Initialize positions
    player1.style.left = `${gameState.player1.position}px`;
    player2.style.left = `${gameState.player2.position}px`;

    function updateScore(player, score) {
        const scoreElement = document.getElementById(`${player}Score`);
        if (scoreElement) {
            scoreElement.textContent = `Puntos: ${score}`;

            const hiddenButton = document.getElementById(`gameForm:increase${player}Score`);
            if (hiddenButton) {
                hiddenButton.click();
            }
        }
    }

    function updateLives(player, lives) {
        const livesElement = document.getElementById(`${player}Lives`);
        if (livesElement) {
            livesElement.textContent = `Vidas: ${lives}`;
            const hiddenButton = document.getElementById(`gameForm:reduce${player}Life`);
            if (hiddenButton) {
                hiddenButton.click();
            }
        }
    }

    document.addEventListener('keydown', (event) => {
        if (gameState.gameOver) return;

        const boardWidth = gameBoard.offsetWidth;

        switch (event.key) {
            // Player 1 - solo si está activo
            case 'ArrowLeft':
                if (gameState.player1.active && gameState.player1.position > 0) {
                    gameState.player1.position -= 10;
                    movePlayer(player1, gameState.player1.position);
                }
                break;
            case 'ArrowRight':
                if (gameState.player1.active && gameState.player1.position < boardWidth - 50) {
                    gameState.player1.position += 10;
                    movePlayer(player1, gameState.player1.position);
                }
                break;
            case ' ':
                if (gameState.player1.active) {
                    shootBullet(player1);
                }
                break;

            // Player 2 - solo si está activo
            case 'a':
                if (gameState.player2.active && gameState.player2.position > 0) {
                    gameState.player2.position -= 10;
                    movePlayer(player2, gameState.player2.position);
                }
                break;
            case 'd':
                if (gameState.player2.active && gameState.player2.position < boardWidth - 50) {
                    gameState.player2.position += 10;
                    movePlayer(player2, gameState.player2.position);
                }
                break;
            case 'w':
                if (gameState.player2.active) {
                    shootBullet(player2);
                }
                break;
        }
    });

    function movePlayer(player, position) {
        player.style.left = `${position}px`;
    }

    function shootBullet(player) {
        if (gameState.gameOver) return;

        const bullet = document.createElement('div');
        bullet.className = 'bullet';
        bullet.style.left = `${player.offsetLeft + 20}px`;
        bullet.style.bottom = '50px';
        bullet.style.position = 'absolute';
        gameBoard.appendChild(bullet);

        const bulletInterval = setInterval(() => {
            const currentBottom = parseInt(bullet.style.bottom);
            if (currentBottom > gameBoard.offsetHeight) {
                clearInterval(bulletInterval);
                bullet.remove();
            } else {
                bullet.style.bottom = `${currentBottom + 5}px`;
                checkBulletCollision(bullet, player);
            }
        }, 50);
    }

    function checkBulletCollision(bullet, sourcePlayer) {
        const bulletRect = bullet.getBoundingClientRect();

        enemies.forEach(enemy => {
            if (enemy.style.display !== 'none') {
                const enemyRect = enemy.getBoundingClientRect();

                if (isColliding(bulletRect, enemyRect)) {

                    const enemyScore = parseInt(enemy.getAttribute('data-score')) || 0;

                    enemy.style.display = 'none';
                    bullet.remove();


                    const playerKey = sourcePlayer.id; // 'player1' o 'player2'
                    gameState[playerKey].score += enemyScore;

                    updateScore(playerKey, gameState[playerKey].score);

                    checkGameStatus();
                }
            }
        });
    }

    function handlePlayerHit(playerNum) {
        const playerKey = `player${playerNum}`;
        if (gameState[playerKey].active) {
            gameState[playerKey].lives--;
            updateLives(playerKey, gameState[playerKey].lives);

            if (gameState[playerKey].lives === 0) {
                gameState[playerKey].active = false;
                const playerElement = document.getElementById(playerKey);
                if (playerElement) {
                    playerElement.style.display = 'none';
                }
            }

            // Verificar game over
            if (!gameState.player1.active && !gameState.player2.active) {
                endGame('Game Over - ¡Ambos jugadores perdieron!');
                // Actualizar el estado en el backend si es necesario
                const gameStatus = document.getElementById('game-status');
                if (gameStatus) {
                    gameStatus.style.display = 'block';
                    gameStatus.textContent = 'Game Over - ¡Ambos jugadores perdieron!';
                }
            }
        }
    }

    function isColliding(rect1, rect2) {
        return !(rect1.right < rect2.left ||
            rect1.left > rect2.right ||
            rect1.bottom < rect2.top ||
            rect1.top > rect2.bottom);
    }

    function moveEnemies() {
        if (gameState.gameOver) return;

        let shouldChangeDirection = false;

        enemies.forEach(enemy => {
            if (enemy.style.display !== 'none') {
                let currentX = parseInt(enemy.style.left) || 0;
                currentX += enemyDirection * enemySpeed;

                if (currentX >= gameBoard.offsetWidth - 50 || currentX <= 0) {
                    shouldChangeDirection = true;
                }

                enemy.style.left = `${currentX}px`;
            }
        });

        if (shouldChangeDirection) {
            enemyDirection *= -1;
        }
    }

    function enemyShoot() {
        if (gameState.gameOver) return;

        const activeEnemies = Array.from(enemies).filter(enemy => enemy.style.display !== 'none');
        if (activeEnemies.length === 0) return;

        const randomEnemy = activeEnemies[Math.floor(Math.random() * activeEnemies.length)];
        const bullet = document.createElement('div');
        bullet.className = 'enemy-bullet';
        bullet.style.position = 'absolute';
        bullet.style.left = `${parseInt(randomEnemy.style.left) + 45}px`;
        bullet.style.top = `${parseInt(randomEnemy.style.top) + 90}px`;
        gameBoard.appendChild(bullet);

        const bulletInterval = setInterval(() => {
            if (gameState.gameOver) {
                clearInterval(bulletInterval);
                bullet.remove();
                return;
            }

            let currentY = parseInt(bullet.style.top);
            currentY += 15;
            bullet.style.top = `${currentY}px`;

            const bulletRect = bullet.getBoundingClientRect();

            if (gameState.player1.active) {
                const player1Rect = player1.getBoundingClientRect();
                if (isColliding(bulletRect, player1Rect)) {
                    bullet.remove();
                    clearInterval(bulletInterval);
                    handlePlayerHit(1);
                }
            }

            if (gameState.player2.active) {
                const player2Rect = player2.getBoundingClientRect();
                if (isColliding(bulletRect, player2Rect)) {
                    bullet.remove();
                    clearInterval(bulletInterval);
                    handlePlayerHit(2);
                }
            }

            if (currentY > gameBoard.offsetHeight) {
                bullet.remove();
                clearInterval(bulletInterval);
            }
        }, 50);
    }

    function endGame(message) {
        gameState.gameOver = true;
        const gameStatus = document.getElementById('game-status');
        if (gameStatus) {
            gameStatus.style.display = 'block';
            gameStatus.textContent = message;
        }

        // Si necesitas actualizar el estado en el backend
        if (message.includes('Victoria')) {
            const victoryButton = document.getElementById('gameForm:checkVictory');
            if (victoryButton) {
                victoryButton.click();
            }
        }
    }

    function checkGameStatus() {
        if (gameState.gameOver) return;

        const activeEnemies = Array.from(enemies).filter(enemy => enemy.style.display !== 'none');
        if (activeEnemies.length === 0) {
            endGame('¡Victoria!');
        }
    }

    // Game loop
    const gameInterval = setInterval(() => {
        if (!gameState.gameOver) {
            moveEnemies();
            enemyShoot();
            checkGameStatus();
        }
    }, 500);
});