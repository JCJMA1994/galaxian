const canvas = document.getElementById('gameCanvas');
const ctx = canvas.getContext('2d');

const socket = new WebSocket('ws://localhost:8080/galaxiagame-1.0-SNAPSHOT/');

socket.onmessage = function(event) {
    const gameState = JSON.parse(event.data);
    drawGame(gameState);
};

function sendAction(action) {
    socket.send(action);
}

function drawGame(state) {
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // Dibujar jugadores
    state.players.forEach(player => {
        ctx.fillStyle = 'blue';
        ctx.fillRect(player.position * 50, 550, 50, 50);
    });

    // Dibujar enemigos
    state.enemies.forEach(enemy => {
        if (enemy.alive) {
            ctx.fillStyle = 'red';
            ctx.fillRect(enemy.col * 50, enemy.row * 50, 50, 50);
        }
    });

    // Dibujar disparos
    state.shots.forEach(shot => {
        ctx.fillStyle = 'yellow';
        ctx.fillRect(shot.x, shot.y, 5, 10);
    });
}
