import axios from 'axios';

export default axios.create({
    // baseURL:'http://localhost:8080/',
    baseURL:'https://moviecritiquehub.onrender.com/',
    headers:{"ngrok-skip-browser-warning":"true"}
});