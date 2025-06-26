import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { TenderComponent } from './Notice/tender/tender.component';
import { ETenderComponent } from './Notice/e-tender/e-tender.component';
import { CirculerComponent } from './Notice/circuler/circuler.component';
import { BuyerListComponent } from './Marchendising/buyer-list/buyer-list.component';
import { AddBuyerComponent } from './Marchendising/add-buyer/add-buyer.component';
import { AddOrderComponent } from './Marchendising/add-order/add-order.component';
import { OrderlistComponent } from './Marchendising/orderlist/orderlist.component';
import { AddMarchendiserOrderComponent } from './Marchendising/add-marchendiser-order/add-marchendiser-order.component';
import { MarchendiserOrderlistComponent } from './Marchendising/marchendiser-orderlist/marchendiser-orderlist.component';
import { AddDesignComponent } from './Design/add-design/add-design.component';
import { DesignListComponent } from './Design/design-list/design-list.component';
import { AddFabricComponent } from './Fabric/add-fabric/add-fabric.component';
import { FabricListComponent } from './Fabric/fabric-list/fabric-list.component';
import { AddCuttingComponent } from './Cutting/add-cutting/add-cutting.component';
import { CuttingListComponent } from './Cutting/cutting-list/cutting-list.component';
import { AddSewingComponent } from './Sewing/add-sewing/add-sewing.component';
import { SewingListComponent } from './Sewing/sewing-list/sewing-list.component';
import { AddFinishingComponent } from './Finishing/add-finishing/add-finishing.component';
import { FinishingListComponent } from './Finishing/finishing-list/finishing-list.component';
import { AddQcCheckComponent } from './Qc/add-qc-check/add-qc-check.component';
import { QcListComponent } from './Qc/qc-list/qc-list.component';
import { AddCollectionComponent } from './Warehouse/add-collection/add-collection.component';
import { CollectioinListComponent } from './Warehouse/collectioin-list/collectioin-list.component';
import { ShipmentlistComponent } from './Shipping/shipmentlist/shipmentlist.component';
import { AddShipmentComponent } from './Shipping/add-shipment/add-shipment.component';
import { Roles } from './Role/role';
import { RoleGuard } from './Guard/role.guard';
import { LoginComponent } from './login/login.component';
import { JobportalComponent } from './jobportal/jobportal.component';
import { JobpostComponent } from './Marchendising/jobpost/jobpost.component';
import { MyNoticeComponent } from './Portal/my-notice/my-notice.component';
import { MyTenderComponent } from './Portal/my-tender/my-tender.component';
import { MyEtenderComponent } from './Portal/my-etender/my-etender.component';
import { MyCirculerComponent } from './Portal/my-circuler/my-circuler.component';
import { ShownoticeComponent } from './Notice/shownotice/shownotice.component';
import { DashboardComponent } from './Marchendising/dashboard/dashboard.component';
import { ProductionDashboardComponent } from './Admin/production-dashboard/production-dashboard.component';
import { AttendenceListComponent } from './Admin/attendence-list/attendence-list.component';
import { OrderInformationComponent } from './Admin/order-information/order-information.component';
import { EmployeeRegistrationComponent } from './HR/employee-registration/employee-registration.component';
import { EmployeeAttendenceComponent } from './HR/employee-attendence/employee-attendence.component';
import { EmployeePaymentComponent } from './HR/employee-payment/employee-payment.component';
import { BuyerTableComponent } from './ADMINPANEL/buyer-table/buyer-table.component';
import { OrderTableComponent } from './ADMINPANEL/order-table/order-table.component';
import { DesignTableComponent } from './ADMINPANEL/design-table/design-table.component';
import { FabricTableComponent } from './ADMINPANEL/fabric-table/fabric-table.component';
import { CuttingTableComponent } from './ADMINPANEL/cutting-table/cutting-table.component';
import { SewingTableComponent } from './ADMINPANEL/sewing-table/sewing-table.component';
import { QcTableComponent } from './ADMINPANEL/qc-table/qc-table.component';
import { WarehouseTableComponent } from './ADMINPANEL/warehouse-table/warehouse-table.component';
import { ShippingTableComponent } from './ADMINPANEL/shipping-table/shipping-table.component';
 export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'about', component: AboutComponent },
    { path: 'contact', component: ContactComponent },
    { path: 'tender', component: TenderComponent },
    { path: 'etender', component: ETenderComponent },
    { path: 'circuler', component: CirculerComponent },
    {path:'portal',component:JobportalComponent},
    {path:'shownotice',component:ShownoticeComponent},
    { path: 'login', component: LoginComponent },
    // THIS IS FOR ADMIN
    {path:'production',component:ProductionDashboardComponent,canActivate:[RoleGuard],data:{roles:[Roles.ADMIN]},
      children:[
        {path:'buyertable',component:BuyerTableComponent},
        {path:'ordertable',component:OrderTableComponent},
        {path:'designtable',component:DesignTableComponent},
        {path:'fabrictable',component:FabricTableComponent},
        {path:'cuttingtable',component:CuttingTableComponent},
        {path:'sewingtable',component:SewingTableComponent},
        {path:'finishingtable',component:SewingTableComponent},
        {path:'qctable',component:QcTableComponent},
        {path:'waretable',component:WarehouseTableComponent},
        {path:'shippingtable',component:ShippingTableComponent}
      ]
      },
    {path:'attendence',component:AttendenceListComponent,canActivate:[RoleGuard],data:{roles:[Roles.ADMIN]}},
    {path:'orderinformation',component:OrderInformationComponent,canActivate:[RoleGuard],data:{roles:[Roles.ADMIN]}},
    // THIS IS HR DEPARTMENT

    {path:'regis',component:EmployeeRegistrationComponent,canActivate:[RoleGuard],data:{roles:[Roles.ADMIN,Roles.HR]}},
    {path:'atten',component:EmployeeAttendenceComponent,canActivate:[RoleGuard],data:{roles:[Roles.ADMIN,Roles.HR]}},
    {path:'pay',component:EmployeePaymentComponent,canActivate:[RoleGuard],data:{roles:[Roles.ADMIN,Roles.HR]}},
  
    // Marchendising
    { path: 'bl', component: BuyerListComponent, canActivate: [RoleGuard], data: { roles: [Roles.MARCH,Roles.ADMIN] } },
    { path: 'ab', component: AddBuyerComponent, canActivate: [RoleGuard], data: { roles: [Roles.MARCH,Roles.ADMIN] } },
    { path: 'ao', component: AddOrderComponent, canActivate: [RoleGuard], data: { roles: [Roles.MARCH,Roles.ADMIN] } },
    { path: 'ol', component: OrderlistComponent, canActivate: [RoleGuard], data: { roles: [Roles.MARCH,Roles.ADMIN] } },
    { path: 'am', component: AddMarchendiserOrderComponent, canActivate: [RoleGuard], data: { roles: [Roles.MARCH,Roles.ADMIN] } },
    { path: 'ml', component: MarchendiserOrderlistComponent, canActivate: [RoleGuard], data: { roles: [Roles.MARCH,Roles.ADMIN] } },
    { path: 'dash', component: DashboardComponent, canActivate: [RoleGuard], data: { roles: [Roles.MARCH,Roles.ADMIN] } },
    { path: 'job', component: JobpostComponent, canActivate: [RoleGuard], data: { roles: [Roles.MARCH,Roles.ADMIN] },
  
      children:[
        {path:'mynotice',component:MyNoticeComponent},
        {path:'mytender',component:MyTenderComponent},
        {path:'myetender',component:MyEtenderComponent},
        {path:'mycirculer',component:MyCirculerComponent}
      ]
  },
  
    // Design
    { path: 'ad', component: AddDesignComponent, canActivate: [RoleGuard], data: { roles: [Roles.DESIGN, Roles.MARCH,Roles.ADMIN] } },
    { path: 'dl', component: DesignListComponent, canActivate: [RoleGuard], data: { roles: [Roles.DESIGN, Roles.MARCH,Roles.ADMIN] } },
  
    // Fabric
    { path: 'af', component: AddFabricComponent, canActivate: [RoleGuard], data: { roles: [Roles.FABRIC, Roles.MARCH,Roles.ADMIN] } },
    { path: 'fl', component: FabricListComponent, canActivate: [RoleGuard], data: { roles: [Roles.FABRIC, Roles.MARCH,Roles.ADMIN] } },
  
    // Cutting
    { path: 'ac', component: AddCuttingComponent, canActivate: [RoleGuard], data: { roles: [Roles.CUTTING, Roles.MARCH,Roles.ADMIN] } },
    { path: 'cl', component: CuttingListComponent, canActivate: [RoleGuard], data: { roles: [Roles.CUTTING, Roles.MARCH,Roles.ADMIN] } },
  
    // Sewing
    { path: 'as', component: AddSewingComponent, canActivate: [RoleGuard], data: { roles: [Roles.SEWING, Roles.MARCH,Roles.ADMIN] } },
    { path: 'sl', component: SewingListComponent, canActivate: [RoleGuard], data: { roles: [Roles.SEWING, Roles.MARCH] } },
  
    // Finishing
    { path: 'afi', component: AddFinishingComponent, canActivate: [RoleGuard], data: { roles: [Roles.FINISHING, Roles.MARCH,Roles.ADMIN] } },
    { path: 'fli', component: FinishingListComponent, canActivate: [RoleGuard], data: { roles: [Roles.FINISHING, Roles.MARCH,Roles.ADMIN] } },
  
    // QC
    { path: 'aq', component: AddQcCheckComponent, canActivate: [RoleGuard], data: { roles: [Roles.QC, Roles.MARCH,Roles.ADMIN] } },
    { path: 'ql', component: QcListComponent, canActivate: [RoleGuard], data: { roles: [Roles.QC, Roles.MARCH,Roles.ADMIN] } },
  
    // Warehouse
    { path: 'aw', component: AddCollectionComponent, canActivate: [RoleGuard], data: { roles: [Roles.WAREHOUSE, Roles.MARCH,Roles.ADMIN] } },
    { path: 'cwl', component: CollectioinListComponent, canActivate: [RoleGuard], data: { roles: [Roles.WAREHOUSE, Roles.MARCH,Roles.ADMIN] } },
  
    // Shipping
    { path: 'addship', component: AddShipmentComponent, canActivate: [RoleGuard], data: { roles: [Roles.SHIPPING, Roles.MARCH,Roles.ADMIN] } },
    { path: 'shiplist', component: ShipmentlistComponent, canActivate: [RoleGuard], data: { roles: [Roles.SHIPPING, Roles.MARCH,Roles.ADMIN] } },
  
    // Fallback
    { path: '**', redirectTo: 'login', pathMatch: 'full' }
  ];
