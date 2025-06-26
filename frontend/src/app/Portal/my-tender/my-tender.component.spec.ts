import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyTenderComponent } from './my-tender.component';

describe('MyTenderComponent', () => {
  let component: MyTenderComponent;
  let fixture: ComponentFixture<MyTenderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MyTenderComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyTenderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
