import apiClient from "./apiClient";

export const fetchAllDept = async () => {
    try {
        const response = await apiClient.get('/departments');
        console.log("All Dept", response);
        return response;
        
    } catch (error) {
        
    }
}

export const addDepartment = async (deptData) => {
    try {
        const response = await apiClient.post('/department', deptData);
        console.log('response', response);
        return response;
    } catch (error) {
        throw error;
    }
}

// to be implemented
export const deleteDepartment = async (deptData) => {
    try {
        const response = await apiClient.delete('/')
    } catch (error) {
        
    }
}

export const getAllDept = async () => {
    try {
        const response = await apiClient.get('/departments');
        return response;
    } catch (error) {
        throw error;
    }
}
