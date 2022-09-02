import axios from "axios";
import {useState} from "react";

export default function Register() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    function register() {
        axios.post("/api/users", {username, password})
            .then(() => alert("Benutzer angelegt"))
            .catch(() => alert("Registration failed"))
            .finally(() => {
                setUsername("");
                setPassword("");
            });
    }

    return <div style={{border: '3px solid blue', padding: '10px'}}>
        <h1>Register</h1>
        <input type="text" placeholder="Username" value={username} onChange={e => setUsername(e.target.value)}/>
        <input type="password" placeholder="Password" value={password} onChange={e => setPassword(e.target.value)}/>
        <button onClick={register}>Register</button>
    </div>
}