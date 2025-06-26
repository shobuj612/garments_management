import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendDesignComponent } from './send-design.component';

describe('SendDesignComponent', () => {
  let component: SendDesignComponent;
  let fixture: ComponentFixture<SendDesignComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SendDesignComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SendDesignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
