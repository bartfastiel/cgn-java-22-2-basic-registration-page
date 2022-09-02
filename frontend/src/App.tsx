import React, {useEffect} from 'react';
import './App.css';
import Login from "./components/Login";
import Secret from "./components/Secret";
import axios from "axios";


function App() {

    const [username, setUsername] = React.useState(undefined);

    function fetchUsername() {
        axios.get("/api/users/me")
            .then(response =>
                response.data
            )
            .then(data => {
                setUsername(data);
            })
            .catch(() => {
                setUsername(undefined)
            });
    }

    useEffect(() => {
        fetchUsername();
    }, []);


    if (!username) {
        return <div>Loading...</div>
    }
    if (username === "anonymousUser") {
        return <Login authenticationChanged={fetchUsername}/>
    }
    return <Secret authenticationChanged={fetchUsername}/>
}

export default App;
