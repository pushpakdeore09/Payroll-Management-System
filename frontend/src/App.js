import './App.css';
import SignInForm from './pages/auth/Login';
import RegisterForm from './pages/auth/Register';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Homepage from './pages/home/Homepage';
import Department from './components/Department/Department';
import Sidebar from './components/Sidebar/Sidebar'; // Import the Sidebar
import EmployeeManagement from './components/EmployeeManagement/EmployeeManagement';
import AddEmployee from './components/EmployeeManagement/AddEmployee';

function App() {
  return (
    <BrowserRouter>
      <div style={{ display: 'flex' }}>
        <Sidebar /> 
        <div style={{ flex: 1, padding: '16px' }}> 
          <Routes>
            <Route path='/signin' element={<SignInForm/>}/>
            <Route path='/signup' element={<RegisterForm/>}/>
            <Route path='/' element={<EmployeeManagement/>}/>
            <Route path='/department' element={<Department/>}/>
            <Route path='/employee' element={<AddEmployee/>}/>
          </Routes>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
