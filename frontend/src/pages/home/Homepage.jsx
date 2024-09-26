import React from 'react'
import Sidebar from '../../components/Sidebar/Sidebar'
import EmployeeManagement from '../../components/EmployeeManagement/EmployeeManagement'

const Homepage = () => {
  return (
    <>
    <div style={{display: "flex"}}>
      <Sidebar/>
      <div style={{flex: 1, padding: "16px"}}>
        <EmployeeManagement/>
      </div>
    </div>
    </>
    
  )
}

export default Homepage