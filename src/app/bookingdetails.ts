import { Resourcedetails } from './resourcedetails';
import { Resource } from './resource';

export class booking {
    bookingId: number;
    resourceDetails: Resourcedetails;
    resource:Resource;
    custName: string;
    custAddress: string;
    phoneNumber: string;
    email: string;
    startDate: Date;
    endDate: Date;
    purpose: string;
    bookingStatus: string;
    pending:string;
}