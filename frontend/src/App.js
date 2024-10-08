import './App.css';
import SignInForm from './pages/auth/Login';
import RegisterForm from './pages/auth/Register';
import { BrowserRouter, Routes, Route, useLocation, useNavigate } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import Homepage from './pages/home/Homepage';
import Department from './components/Department/Department';
import Sidebar from './components/Sidebar/Sidebar'; 
import EmployeeManagement from './components/EmployeeManagement/EmployeeManagement';
import AddEmployee from './components/EmployeeManagement/AddEmployee';
import AddPayrollMonth from './components/Payroll/AddPayrollMonth';
import EditEmployee from './components/EmployeeManagement/EditEmployee';
import Payroll from './components/Payroll/Payroll';
import PayrollMonth from './components/Payroll/PayrollMonth';

function AppContent() {
  const location = useLocation();
  const showSidebar = location.pathname !== '/signin' && location.pathname !== '/signup';


  
  return (
    <div style={{ display: 'flex' }}>
      {showSidebar && <Sidebar />}
      <div style={{ flex: 1 }}>
        <Routes>
          <Route path='/signin' element={<SignInForm />} />
          <Route path='/signup' element={<RegisterForm />} />
          <Route path='/' element={<Homepage />} />
          <Route path='/department' element={<Department />} />
          <Route path='/employee' element={<EmployeeManagement />} />
          <Route path='/addEmployee' element={<AddEmployee/>}/>
          <Route path='/employee/:employeeId' element={<EditEmployee/>}/>
          <Route path='/addPayrollMonth' element={<AddPayrollMonth/>}/>
          <Route path='/payrollMonth' element={<PayrollMonth/>}/>
          <Route path='/payroll' element={<Payroll/>}/>
        </Routes>
      </div>
    </div>
  );
}

function App() {
  return (
    
      <BrowserRouter>
        <AppContent />
        <ToastContainer/>
      </BrowserRouter>
  );
}

export default App;
