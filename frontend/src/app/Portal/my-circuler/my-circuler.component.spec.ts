import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyCirculerComponent } from './my-circuler.component';

describe('MyCirculerComponent', () => {
  let component: MyCirculerComponent;
  let fixture: ComponentFixture<MyCirculerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MyCirculerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyCirculerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
