import apiClient from "./apiClient";

export const fetchAllDept = async () => {
    try {
        const response = await apiClient.get('/departments');
        return response;
        
    } catch (error) {
        
    }
}

export const addDepartment = async (deptData) => {
    try {
        const response = await apiClient.post('/department', deptData);
        return response;
    } catch (error) {
        throw error;
    }
}


export const deleteDepartment = async (deptId) => {
    try {
        const response = await apiClient.delete(`/department/${deptId}`)
        return response.data;
    } catch (error) {
        throw error;
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

export const getDeptByName = async (deptName) => {
    try {
        const response = await apiClient.get(`/department/${deptName}`);
        
        return response;
    } catch (error) {
        throw error;
    }
}
