import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Login from "./components/Login";
import FileUpload from "./components/fileUpload";
import StatsSummary from "./components/StatsSummary";

const App = () => {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/upload" element={<FileUpload />} />
        <Route path="/dashboard" element={<StatsSummary />} />
      </Routes>
    </Router>
  );
};

export default App;
