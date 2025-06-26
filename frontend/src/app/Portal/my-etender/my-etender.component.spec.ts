import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyEtenderComponent } from './my-etender.component';

describe('MyEtenderComponent', () => {
  let component: MyEtenderComponent;
  let fixture: ComponentFixture<MyEtenderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MyEtenderComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyEtenderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
