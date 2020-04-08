import { Course } from './course';
import { Payment } from './payment';

export class Registration {
    registrationId: number;
    registrationDate: Date;
    name: string;
    address: string;
    district: string;
    state: string;
    pincode: number;
    nationality: string;
    phone: string;
    gender: string;
    dateOfBirth: Date;
    email: string;
    courseId: Course;
    paymentId: Payment;
    photo: any;


}
