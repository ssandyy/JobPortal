import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Home, Feed, Dashboard, Create, Company } from "./pages"

function App() {
  return (
    <BrowserRouter>
      <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/employer" >
          <Route path="/employer/dashboard" element={<Dashboard />}/>
          <Route path="/employer/create" element={<Create />}/>
          
          </Route>
          <Route path="/employee/feed" element={<Feed />}/>
          <Route path="/employer/company" element={<Company />}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
