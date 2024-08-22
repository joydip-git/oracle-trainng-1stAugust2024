import axios from "axios";
import { API_URL } from "./constants";

const axiosInstance = axios.create({
    baseURL: API_URL,
    timeout: 3000,
    timeoutErrorMessage: 'request timed out'
})
// axiosInstance.interceptors.request.use(
//     (req) => {
//         req.headers.Authorization = ''
//         return req
//     }
// )
export default axiosInstance